from django.shortcuts import render
from django.http import HttpResponse


def index(request):
    return HttpResponse("Hello World You are a terrible person")
    
    
def main(request):
    return HttpResponse("Its a main page")
# Create your views here.
