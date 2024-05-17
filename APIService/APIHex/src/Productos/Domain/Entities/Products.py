from uuid import uuid4


class Products:
    def __init__(self, nombre, precio, stock):
        self.id = uuid4()
        self.nombre = nombre
        self.precio = precio
        self.stock = stock