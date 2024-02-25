fun redondearDosDecimales(numero: Float): Float {
    val factorDeRedondeo = 100.0f
    return (numero * factorDeRedondeo).toInt() / factorDeRedondeo
}

fun main() {
    // Ejemplo de uso
    val automovil = Automovil("Volkswagen", "Golf", 600f, 400f, 15000f, true)
    val motocicleta = Motocicleta("Yamada", "20", 350f, 200f, 8000f, 550)

    println("Información del automóvil:")
    println(automovil.obtenerInformacion())
    println("\nInformación de la motocicleta:")
    println(motocicleta.obtenerInformacion())

    // Realizar un viaje con el automóvil
    val distanciaViajeAutomovil = 200f
    println("\nRealizando un viaje con el automóvil...")
    val combustibleRestanteAutomovil = automovil.realizaViaje(distanciaViajeAutomovil)
    println("Autonomía restante del automóvil después del viaje: ${automovil.calcularAutonomia()}")
    println("Combustible restante del automóvil después del viaje: $combustibleRestanteAutomovil")

    // Realizar un viaje con la motocicleta
    val distanciaViajeMotocicleta = 150f
    println("\nRealizando un viaje con la motocicleta...")
    val combustibleRestanteMotocicleta = motocicleta.realizaViaje(distanciaViajeMotocicleta)
    println("Autonomía restante de la motocicleta después del viaje: ${motocicleta.calcularAutonomia()}")
    println("Combustible restante de la motocicleta después del viaje: $combustibleRestanteMotocicleta")

    // Realizar derrape con el automóvil
    println("\nRealizando un derrape con el automóvil...")
    automovil.realizaDerrape()
    println("Combustible restante del automóvil después del derrape: ${automovil.combustibleActual}")

    // Realizar caballito con la motocicleta
    println("\nRealizando un caballito con la motocicleta...")
    motocicleta.realizaCaballito()
    println("Combustible restante de la motocicleta después del caballito: ${motocicleta.combustibleActual}")

}