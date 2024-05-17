from src.Productos.Domain.Ports.ProductPort import ProductPort as Ports


class GetUseCase:
    def __init__(self, repository: Ports):
        self.__repository = repository

    def run(self):
        return self.__repository.get_productos()