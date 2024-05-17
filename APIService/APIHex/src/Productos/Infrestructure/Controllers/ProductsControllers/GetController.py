from src.Productos.Application.UseCase.Products.Get import GetUseCase as UseCase, Ports


class GetController:
    def __init__(self, repository: Ports):
        self.__use_case = UseCase(repository)

    def run(self):
        return self.__use_case.run()