from src.Productos.Domain.Entities.Products import Products
from abc import ABC, abstractmethod


class ProductPort(ABC):
    @abstractmethod
    def __init__(self):
        pass

    @abstractmethod
    def get_productos(self):
        pass

    @abstractmethod
    def create_n_productos(self, productos: list[Products]):
        pass

    @abstractmethod
    def delete_productos(self, id):
        pass