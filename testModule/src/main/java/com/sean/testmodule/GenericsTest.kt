package com.sean.testmodule

import java.lang.StringBuilder

/**
 * Author: Sean-Shen
 * Date: 2021/4/19
 * Desc: 泛型的学习与使用
 */
class GenericsTest<T> {
    fun getName(param: T): T {
        return param
    }
}

class GenericsTest2() {
    fun <T> getName(param: T): T {
        return param
    }
}

object Test {
    val gen1 = GenericsTest<Int>()
    val gen2 = GenericsTest2()

    val stringBuilder = StringBuilder()

    fun getName() {
        gen1.getName(1)
        gen2.getName<String>("2")
        stringBuilder.apply {  }
    }
}