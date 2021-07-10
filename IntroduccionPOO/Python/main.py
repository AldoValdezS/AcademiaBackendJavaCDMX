from car import Car
from account import Account
if __name__ == "__main__":
    car = Car("AMS123", Account("AldoVS","credencial"))    
    print(vars(car))
    print(vars(car.driver))
    