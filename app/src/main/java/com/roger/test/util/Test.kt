package com.roger.test.util

class Test {


    fun main(args: Array<String>) {

        // let 做 非空判断  或者将对象作为参数传递给其他函数。
        // 用途：通常用于对非空对象执行操作，或者将对象作为参数传递给其他函数。
        // 返回值：返回 lambda 表达式的结果。
        // 上下文对象：通过 it 访问。
        // 使用场景：对象非空时执行操作，或者链式调用。
        val name:String? = null
//        name = "Kotlin"
        name?.let{

        }

        // run 上下文中执行操作并返回结果，使用 run。
        //
        // 返回值：返回 lambda 表达式的结果。
        //
        //上下文对象：通过 this 访问（可以省略）。
        //
        //使用场景：需要在对象上下文中执行一些操作并返回结果。
        val length = "Kotlin".run {
            this.length
            length
        }


        // with 对对象进行多次操作使用with
        //
        // 返回值：返回 lambda 表达式的结果。
        //
        //上下文对象：通过 this 访问（可以省略）。
        //
        //使用场景：对一个对象执行多个操作，不需要链式调用。
        val result = with("Kotlin") {
            length
        }


        // apply  如果需要初始化或配置对象，使用 apply。
        //
        // 返回值：返回对象本身（this）。
        //
        //上下文对象：通过 this 访问（可以省略）。
        //
        //使用场景：初始化或配置对象。
        val person = Person().apply {
            this.name = "Roger"
            this.age = 18
        }


        // also 如果需要在链式调用中执行副作用操作，使用also，
        //
        // 返回值：返回对象本身（this）。
        //
        //上下文对象：通过 it 访问。
        //
        //使用场景：需要在链式调用中执行一些副作用操作。
        val list = mutableListOf(1,2,3).also {
            print("current list is $it")
            it.add(4)
        }


    }
}

class Person {
    var name:String? = null
    var age :Int = 0
}