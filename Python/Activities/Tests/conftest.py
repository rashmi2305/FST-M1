import pytest 

@pytest.fixture
def mylist():
    list1 = list(range(11))
    return list1

