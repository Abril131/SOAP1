from flask import Blueprint, request
from src.Productos.Infrestructure.Controllers.ProductsControllers.GetController import GetController
from src.Productos.Infrestructure.Controllers.ProductsControllers import DeleteController
from src.Productos.Infrestructure.Controllers.ProductsControllers.CreateController import CreateController
from src.Productos.Infrestructure.Repositories.ProductsRepository import ProductsRepository

product_routes = Blueprint('product_routes', __name__)

repo = ProductsRepository()
get_controller = GetController(repo)
delete_controller = DeleteController(repo)
create_controller = CreateController(repo)

@product_routes.route("/", methods=["GET"])
def get():
    return get_controller.run()

@product_routes.route("/", methods=["POST"])
def create():
    return create_controller.run(request)

@product_routes.route("/<string:id>", methods=["DELETE"])
def delete(id):
    return delete_controller.run(id)