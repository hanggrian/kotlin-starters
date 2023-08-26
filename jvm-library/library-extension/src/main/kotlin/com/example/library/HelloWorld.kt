package com.example.library

class HelloWorld : Hello() {
    override fun toString(): String = "${super.toString()} World"
}
