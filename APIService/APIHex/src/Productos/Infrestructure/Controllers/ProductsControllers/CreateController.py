from src.Productos.Application.UseCase.Products.Create import CreateUseCase as UseCase, Ports


class CreateController:
    def __init__(self, repository:Ports):
        self.__use_case = UseCase(repository)

    def run(self, request):
        return self.__use_case.run(request.get_json())