class Automovil(
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    val esHibrido: Boolean,

) : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    companion object {
        const val AHORRO_ELECTRICO = 5.0f

        private var condicionBritanica: Boolean = false

        fun cambiarCondicionBritanica(nuevaCondicion: Boolean) {
            condicionBritanica = nuevaCondicion
        }
    }

    override fun calcularAutonomia(): Float {
        var autonomia = super.calcularAutonomia()
        if (esHibrido) {
            autonomia += AHORRO_ELECTRICO
        }
        return autonomia
    }

    fun realizaDerrape(): Float {
        val gasto = if (esHibrido) 6.25f else 7.5f
        if (combustibleActual > gasto) {
            combustibleActual -= gasto
        } else {
            println("No se puede realizar el derrape, no hay combustible suficiente.")
        }
        return combustibleActual
    }
}


