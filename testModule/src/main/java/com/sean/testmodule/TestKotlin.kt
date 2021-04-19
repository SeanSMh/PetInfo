package com.sean.testmodule

/**
 * Author: Sean-Shen
 * Date: 2021/4/19
 * Desc:
 */
class TestKotlin {

    //测试inline fun
    /**
     * 使用inline，可以抵消lambda表达式带来的运行时开销。
     * 抵消原理：将内联函数替换到被调用的地方
     * 1、将lambda具体实现，替换到内联函数的lambda调用的地方。
     * 2、将整个内联函数，替换到调用它的地方。
     */
    private inline fun inlineTest(name: String, age: String, lambda2: (String, String) -> Unit) {
        lambda2.invoke(name, age)
    }

    /**
     * noinline修饰的lambda，保持了lambda的特性，不进行内联优化。
     */
    inline fun inlineTest3(ld: (Int) -> Int, noinline ld2: (String) -> Int) {

    }

    /**
     * crossinline：解决外部lambda允许return返回，内部匿名内部类不允许return返回的矛盾
     * 原理：禁止crossinline修饰的lambda非局部return返回，这样内外就一致了。
     * （inline 修饰的lambda可以有非局部return返回，也就是直接return，而普通lambda只有局部return返回，没有非局部返回。
     * 局部返回：return@xx
     * 非局部返回：return
     */
    private inline fun inlineTest2(crossinline lambdaTest: (Int) -> Int) {
        Runnable {
            print("内部lambda")
        }
    }

    /**
     * 测试infix函数
     */
    private infix fun <T> T.alter(block: (T) -> Unit): T {
        block(this)
        return this
    }

    /**
     * 泛型 + 拓展函数学习与使用
     */
    private inline fun <T> T.builder(block: T.() -> Unit): T {
        block()
        return this
    }

    private inline fun <T> T.builder2(block: () -> Unit) {
        block()
    }

    fun test() {
        val name = "Sean"
        val age = "24"
        inlineTest(name, age) { na, ag ->
            print(na + ag)
        }

        name.alter {
            print(name)
        }

        name alter {  //中缀表达式
            print(name)
        }

        name.builder {
            print("泛型拓展builder")
        }

        name.builder2 {

        }
    }
}