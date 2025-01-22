fun pedirTiempo(msj:String,aceptaVacio: Boolean = false):Int{
    var tiempo:Int? = null
    do {
        try {
            println("Dame $msj")
            println(">> ")
            val entrada = readln().trim()
            if(aceptaVacio && entrada.isEmpty()){
                tiempo = entrada.toInt()
            }
            else{
                tiempo = entrada.toInt()
            }
        }catch(e:Exception){
            println("*ERROR* ${e.message}")
        }
    }while (tiempo == null)
    return tiempo
}


fun main(){
    val hora1 = pedirTiempo("la hora")
    val min1 = pedirTiempo("los minutos",true)
    val seg1 = pedirTiempo("los segundos",true)
    val tiempo1 = Tiempo(hora1,min1,seg1)
    println(tiempo1)

    val hora2 = pedirTiempo("la hora")
    val min2 = pedirTiempo("los minutos",true)
    val seg2 = pedirTiempo("los segundos",true)
    val tiempo2 = Tiempo(hora2,min2,seg2)
    println(tiempo2)

    println(tiempo2.esMayorQue(tiempo1))
    println(tiempo1.esMenorQue(tiempo2))
    println(tiempo1.copiar())
    println(tiempo1.copiar(tiempo2))
    println(tiempo1.sumar(tiempo2))
    println(tiempo1.restar(tiempo2))

    println(tiempo1.comparar(tiempo2))
    println(tiempo2.comparar(tiempo1))
}