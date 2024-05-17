from src.Productos.Domain.Ports.ProductPort import ProductPort as Ports, Products

class CreateUseCase:
    def __init__(self, repository: Ports):
        self.__repository = repository

    def run(self, data):
        productos = [Products(**d) for d in data]
        return self.__repository.create_n_productos(productos)