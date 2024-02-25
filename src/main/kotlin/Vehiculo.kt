open class Vehiculo(
    val marca: String,
    val modelo: String,
    private val capacidadCombustible: Float = 10.0f,
    combustibleActual: Float,
    kilometrosActuales: Float
) {

    /** Set de combustible actual */
    var combustibleActual: Float = combustibleActual
        get() {
            return redondearDosDecimales(field)
        }
        set(valor) {
            field = comprobarCombustibleActual(valor)
        }

    var kilometrosActuales: Float = kilometrosActuales
        get() {
            return redondearDosDecimales(field)
        }
        set(valor) {
            field = comprobarKilometrosActuales(kilometrosActuales)
            field = valor
        }

    /** Incializamos la comprobación del combustible actual */
    init {
        comprobarCombustibleActual(combustibleActual)
        comprobarKilometrosActuales(kilometrosActuales)
    }

    /** Companion object con las constantes de la clase*/
    companion object {
        const val KM_POR_LITRO = 10.0f
    }

    /** Funcion que comprueba el combustible actual */
    private fun comprobarCombustibleActual(valor: Float): Float {
        require(valor >= 0f) { "El combustible no puede ser negativo." }
        require(valor <= capacidadCombustible) { "El combustible no puede exceder la capacidad del depósito." }
        return valor
    }

    /** Funcion que comprueba los kilometros actuales */
    private fun comprobarKilometrosActuales(valor: Float): Float {
        require(valor >= 0f) { "Los kilómetros actuales no pueden ser negativos." }
        return valor
    }

    /** Función que imprime la información de la autonomia*/
    open fun obtenerInformacion(): String {
        val autonomia = calcularAutonomia()
        return "El vehículo puede recorrer $autonomia kilómetros."
    }

    /** Función que calcula la autonomía */
    open fun calcularAutonomia(): Float {
        return redondearDosDecimales(combustibleActual * KM_POR_LITRO)
    }

    /** Función que realiza el viaje */
    open fun realizaViaje(distancia: Float): Float {
        val distanciaMaxima = calcularAutonomia()
        if (distancia <= distanciaMaxima) {
            val combustibleConsumido = distancia / KM_POR_LITRO
            combustibleActual -= combustibleConsumido
            kilometrosActuales += distancia
            return 0f
        } else {
            val distanciaRestante = distanciaMaxima - kilometrosActuales
            combustibleActual = 0f
            kilometrosActuales += distanciaRestante
            return redondearDosDecimales(distancia - distanciaRestante)
        }
    }

    /** Función que reposta*/
    open fun repostar(cantidad: Float): Float {
        if (cantidad <= 0f) {
            val repostado = capacidadCombustible - combustibleActual
            combustibleActual = capacidadCombustible
            return repostado
        } else {
            val espacioDisponible = capacidadCombustible - combustibleActual
            if (cantidad <= espacioDisponible) {
                combustibleActual += cantidad
                return cantidad
            } else {
                combustibleActual = capacidadCombustible
                return espacioDisponible
            }
        }
    }
}

