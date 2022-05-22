package com.example.mycalculator

class TratamientoDelString(val sizeOperacion: Int) {
    fun addSymbolIfPossible(simbolo: Char, operacionCompleta: String): String {
        val arrayOperacion = operacionCompleta.toCharArray()
        var nuevaOperacion = ""
        when (simbolo) {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                if (arrayOperacion.size < sizeOperacion) {
                    nuevaOperacion = operacionCompleta + simbolo
                } else {
                    nuevaOperacion = operacionCompleta
                }
            }
            '+', '/', 'x' -> {
                if (arrayOperacion.size < sizeOperacion && arrayOperacion.isNotEmpty()) {
                    when (arrayOperacion.last()) {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                            nuevaOperacion = operacionCompleta + simbolo
                        }
                        '+', '/', 'x' -> {
                            nuevaOperacion =
                                operacionCompleta.take(operacionCompleta.length - 1) + simbolo
                        }
                        '-' -> {
                            if (arrayOperacion.size != 1) {
                                nuevaOperacion =
                                    operacionCompleta.take(operacionCompleta.length - 1) + simbolo
                                when (operacionCompleta.get(operacionCompleta.length - 2)){
                                    'x','/' ->{
                                        nuevaOperacion = operacionCompleta
                                    }
                                    else -> {
                                        operacionCompleta.take(operacionCompleta.length - 1) + simbolo
                                    }
                                }
                            } else {
                                nuevaOperacion = operacionCompleta
                            }
                        }
                        '.' -> {
                            if (arrayOperacion.size > 1) {
                                when (arrayOperacion.get(arrayOperacion.size - 2)) {
                                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                                        nuevaOperacion = operacionCompleta + simbolo
                                    }
                                    else -> {
                                        nuevaOperacion = operacionCompleta
                                    }
                                }
                            } else {
                                nuevaOperacion = operacionCompleta
                            }
                        }
                        else -> {
                            nuevaOperacion = operacionCompleta
                        }
                    }
                } else {
                    nuevaOperacion = operacionCompleta
                }
            }
            '-' -> {
                if (arrayOperacion.size < sizeOperacion && arrayOperacion.isNotEmpty()) {
                    when (arrayOperacion.last()) {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                            nuevaOperacion = operacionCompleta + simbolo
                        }
                        '/', 'x' -> {
                            nuevaOperacion = operacionCompleta + simbolo
                        }
                        '-', '+' -> {
                            nuevaOperacion =
                                operacionCompleta.take(operacionCompleta.length - 1) + simbolo
                        }
                        '.' -> {
                            if (arrayOperacion.size > 1) {
                                when (arrayOperacion.get(arrayOperacion.size - 2)) {
                                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                                        nuevaOperacion = operacionCompleta + simbolo
                                    }
                                    else -> {
                                        nuevaOperacion = operacionCompleta
                                    }
                                }
                            } else {
                                nuevaOperacion = operacionCompleta
                            }
                        }
                        else -> {
                            nuevaOperacion = operacionCompleta
                        }
                    }
                } else if (arrayOperacion.isEmpty()) {
                    nuevaOperacion = operacionCompleta + simbolo
                } else {
                    nuevaOperacion = operacionCompleta
                }

            }
            '.' -> {
                if (arrayOperacion.size < sizeOperacion && arrayOperacion.isNotEmpty()) {
                    when (arrayOperacion.last()) {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                            for (i in (arrayOperacion.size - 1) downTo 0) {
                                when (arrayOperacion.get(i)) {
                                    '+', '-', '/', 'x' -> {
                                        nuevaOperacion = operacionCompleta + simbolo
                                        break
                                    }
                                    '.' -> {
                                        nuevaOperacion = operacionCompleta
                                        break
                                    }
                                    else -> {
                                        if (i == 0) {
                                            nuevaOperacion = operacionCompleta + simbolo
                                            break
                                        }
                                    }
                                }
                            }
                        }
                        '+', '-', '/', 'x' -> {
                            nuevaOperacion = operacionCompleta + simbolo
                        }
                        '.' -> {
                            nuevaOperacion = operacionCompleta
                        }
                        else -> {
                            nuevaOperacion = operacionCompleta
                        }
                    }
                } else if (arrayOperacion.isEmpty()) {
                    return operacionCompleta + simbolo
                } else {
                    nuevaOperacion = operacionCompleta
                }
            }
            else -> {
                nuevaOperacion = operacionCompleta
            }
        }
        return nuevaOperacion
    }
}
