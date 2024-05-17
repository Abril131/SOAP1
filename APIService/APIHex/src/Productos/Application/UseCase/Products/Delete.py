from src.Productos.Domain.Ports.ProductPort import ProductPort as Ports

class DeleteUseCase:
    def __init__(self, repository: Ports):
        self.__repository = repository

    def run(self, id):
        return self.__repository.delete_productos(id)