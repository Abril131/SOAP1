from flask import Blueprint, request
from src.Productos.Infrestructure.Controllers.ProductosControllers.GetController import GetController
from src.Productos.Infrestructure.Controllers.ProductosControllers.DeleteController import DeleteController
from src.Productos.Infrestructure.Controllers.ProductosControllers.CreateController import CreateController
from src.Productos.Infrestructure.Repositories.MySQLRepositories.ProductosRepository import ProductosRepository
from src.Productos.Infrestructure.Controllers.ProductosControllers.UpdateCantidadByEventController import UpdateCantidadByEventController
import pika
import json
from threading import Thread

product_routes = Blueprint('product_routes', __name__)

repo = ProductosRepository()
get_controller = GetController(repo)
delete_controller = DeleteController(repo)
create_controller = CreateController(repo)
update = UpdateCantidadByEventController(repo)


def callback(ch, method, properties, body):
    data = json.loads(body)
    ch.basic_ack(delivery_tag=method.delivery_tag)


def start_conuming_queue_change_ordenstatus():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channel = connection.channel()
    channel.queue_declare(queue='queue.change_ordenstatus', durable=True)
    channel.basic_consume(queue='queue.change_ordenstatus', on_message_callback=callback)
    channel.start_consuming()

def start_consumer_queue_change_orden_status_thread():
    consumer_thread = Thread(target=start_conuming_queue_change_ordenstatus())
    consumer_thread.daemon = True
    consumer_thread.start()

@product_routes.route("/", methods=["GET"])
def get():
    return get_controller.run()

@product_routes.route("/", methods=["POST"])
def create():
    return create_controller.run(request)

@product_routes.route("/<string:id>", methods=["DELETE"])
def delete(id):
    return delete_controller.run(id)

