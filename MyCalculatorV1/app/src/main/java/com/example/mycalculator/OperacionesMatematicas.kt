package com.example.mycalculator

class OperacionesMatematicas {
    fun ejecutarOperacion(operacionCompleta: String): String {
        var resultado = ""
        if (operacionCompleta.isNotEmpty()) {
            resultado = ejcutarOperacionArray(separarOperacionEnArray(operacionCompleta))
        }
        return if (resultado != operacionCompleta) resultado else {
            ""
        }
    }

    fun operacionSimple(num1: String, num2: String, operador: Char): String {
        return when (operador) {
            'x' -> {
                (num1.toDouble() * num2.toDouble()).toString()
            }
            '/' -> {
                (num1.toDouble() / num2.toDouble()).toString()
            }
            '+' -> {
                (num1.toDouble() + num2.toDouble()).toString()
            }
            '-' -> {
                (num1.toDouble() - num2.toDouble()).toString()
            }
            else -> {
                ""
            }
        }
    }

    fun ejcutarOperacionArray(arrayOperacionCompleta: List<String>): String {
        val arrayTerminosSimpificados: MutableList<String> = ArrayList()
        var acabaDeSimplificar = false
        var resultado = "0"
        // Resolver operaciones multiplicacion y division antes, ó simplificacion de terminos
        for (i in arrayOperacionCompleta.indices) {
            if (!acabaDeSimplificar) {
                when (arrayOperacionCompleta[i]) {
                    "/" -> {
                        if (i != arrayOperacionCompleta.size - 1) {
                            arrayTerminosSimpificados[arrayTerminosSimpificados.size - 1] =
                                operacionSimple(
                                    arrayTerminosSimpificados.last(),
                                    arrayOperacionCompleta[i + 1],
                                    '/'
                                )
                            acabaDeSimplificar = true
                        }
                    }
                    "x" -> {
                        if (i != arrayOperacionCompleta.size - 1) {
                            arrayTerminosSimpificados[arrayTerminosSimpificados.size - 1] =
                                operacionSimple(
                                    arrayTerminosSimpificados.last(),
                                    arrayOperacionCompleta[i + 1],
                                    'x'
                                )
                            acabaDeSimplificar = true
                        }
                    }
                    "+" -> {
                    }
                    else -> {
                        arrayTerminosSimpificados.add(arrayOperacionCompleta[i])
                    }
                }
            } else {
                acabaDeSimplificar = false
            }
        }

        // Realizar la suma de los terminos simplificados
        for (i in arrayTerminosSimpificados.indices) {
            resultado = operacionSimple(resultado, arrayTerminosSimpificados[i], '+')
        }
        return if (resultado.toDouble().mod(1.0) == 0.0) {
            resultado.toDouble().toLong().toString()
        } else {
            resultado
        }

    }

    fun separarOperacionEnArray(stringOperacion: String): List<String> {
        val arrayOperacion: MutableList<String> = ArrayList()
        var numero = ""
        for (i in stringOperacion.indices) {
            when (stringOperacion[i]) {
                in '0'..'9' -> {
                    numero += stringOperacion[i]
                    if (i == stringOperacion.length - 1) {
                        arrayOperacion.add(numero)
                    }
                }
                '.' -> {
                    if (numero == "" || numero == "-") {
                        numero += "0."
                    } else {
                        numero += '.'
                    }

                    if (i == stringOperacion.length - 1) {
                        arrayOperacion.add(numero)
                    }
                }
                '+', 'x', '/' -> {
                    arrayOperacion.add(numero)
                    arrayOperacion.add(stringOperacion[i].toString())
                    numero = ""
                }
                '-' -> {
                    numero = if (i != 0) {
                        arrayOperacion.add(numero)
                        arrayOperacion.add("+")
                        "-"
                    } else {
                        "-"
                    }
                }
                else -> {
                }
            }
        }
        return arrayOperacion
    }
}