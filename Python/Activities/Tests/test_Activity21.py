import pytest 

	
@pytest.mark.skip
def test_sum():
    num1 = 10
    num2 = 8
    assert num1+num2 == 18
	
@pytest.mark.skip    
def test_diff():
    num1 = 10
    num2 = 8
    assert num1-num2 == 2

@pytest.mark.skip    
def test_product():
    num1 = 10
    num2 = 8
    assert num1*num2 == 80
	
@pytest.mark.skip    
def test_quotient():
    num1 = 10
    num2 = 8
    assert num1/num2 == 18
