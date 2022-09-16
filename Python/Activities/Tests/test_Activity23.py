import pytest 

def test_sumList(mylist):
    intSum = 0
    for item in mylist:
        intSum = int(intSum) + int(item) 
        
    assert int(intSum)==55