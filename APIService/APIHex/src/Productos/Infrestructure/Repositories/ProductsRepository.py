from src.Productos.Domain.Ports.ProductPort import ProductPort
from src.Productos.Domain.Entities.Products import Products
from src.Productos.Infrestructure.Models.Products import Products as Model
from src.Productos.Infrestructure.Data.Responses.BaseResponse import BaseResponse
from src.DataBase.Connection import Base, engine, session_local

class ProductsRepository(ProductPort):
    def __init__(self):
        Base.metadata.create_all(bind=engine)
        self.db = session_local()

    def get_productos(self):
        productos = [p.to_dict() for p in self.db.query(Model).all()]
        status = True if productos else False
        message = "Productos encontrados exitosamente" if status else "Productos no encontrados"
        status_code = 200 if status else 500
        return self.generate_response(productos, message, status, status_code)

    def create_n_productos(self, productos: list[Products]):
        news = [Model(**producto.__dict__) for producto in productos]
        [self.db.add(new) for new in news]
        self.db.commit()
        responses = [n.to_dict() for n in news]
        return self.generate_response(responses, "Productos creados exitosamente", True, 201)

    def delete_productos(self, id):
        producto = self.db.query(Model).filter(Model.id == id).first()
        status = True
        status_code = 200
        message = "Producto eliminado con exito"
        if producto:
            self.db.delete(producto)
            self.db.commit()
        else:
            status = False
            message = "Producto no encontrado"
            status_code = 500
        return {"message": message, "status": status}, status_code

    def generate_response(self, data, message, status, httpsstatuscode):
        return BaseResponse(data, message, status, httpsstatuscode).response()