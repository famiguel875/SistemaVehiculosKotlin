class Motocicleta(
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    val cilindrada: Int
) : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    companion object {
        const val MIN_CILINDRADA = 125
        const val MAX_CILINDRADA = 1000
        const val AHORRO_MOTOCICLETA = 20.0f
    }
    init {
        require(cilindrada in MIN_CILINDRADA..MAX_CILINDRADA) {
            "La cilindrada debe estar entre $MIN_CILINDRADA y $MAX_CILINDRADA cc"
        }
    }

    override fun calcularAutonomia(): Float {
        var autonomia = super.calcularAutonomia()
        autonomia += AHORRO_MOTOCICLETA
        if (cilindrada < MAX_CILINDRADA) {
            val restaPorCilindrada = (MAX_CILINDRADA - cilindrada) / 1000f
            autonomia -= restaPorCilindrada
        }
        return autonomia
    }

    fun realizaCaballito(): Float {
        val gasto = 6.5f
        if (combustibleActual > gasto) {
            combustibleActual -= gasto
        } else {
            println("No se puede realizar el derrape, no hay combustible suficiente.")
        }
        return combustibleActual
    }
}