import pytest               #Import pytest 
import math 
def test_sqrt():                #Pass
    num=25 
    assert math.sqrt(num) == 5
def test_square():              #Fail
    num = 7
    assert num*num == 40
def tesequality():              #No Run  - when we run using only command 'pytest' and name doesnt have 'test in it
    assert 10==11

