import pytest 

	

@pytest.mark.operate
def sum():
    num1 = 10
    num2 = 8
    assert num1+num2 == 18

@pytest.mark.skip
@pytest.mark.operation
def diff():
    num1 = 10
    num2 = 8
    assert num1-num2 == 2

@pytest.mark.skip
@pytest.mark.operation    
def product():
    num1 = 10
    num2 = 8
    assert num1*num2 == 80

@pytest.mark.skip
@pytest.mark.operation
def quotient():
    num1 = 10
    num2 = 8
    assert num1/num2 == 18
