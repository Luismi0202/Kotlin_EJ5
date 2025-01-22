class Tiempo(
    var hora: Int,
    var minutos: Int,
    var segundos: Int
) {
    init{
        require(hora >= 0){"¡Horas debe ser positivo"}
        require(minutos >= 0){"¡Min debe ser positivo o cero!"}
        require(segundos >= 0 ){"¡Min debe ser positivo o 0!"}

        if(segundos > 59){
            minutos += segundos / 60
            segundos = segundos % 60 //los cojo del resto
        }
        if(minutos > 59){
            hora += minutos / 60
            minutos = minutos % 60 //los cojo del resto
        }
        require(hora in 0..23 || (hora == 24 && minutos == 0 && segundos == 0)){"Hora no válida (máx 24 00 00)"}
    }

    fun incrementar(t: Tiempo):Boolean{
        var horaFinal = hora + t.hora
        var minutosFinal = minutos + t.minutos
        var segundosFinal = segundos + t.segundos

        if(segundosFinal > 59){
            minutosFinal += (segundosFinal / 60)
            minutosFinal %= 60
        }

        if(minutosFinal > 59){
            horaFinal += (segundosFinal / 60)
            minutosFinal %= 60
        }

        if(horaFinal >= 24) {
            return false
        }else{
            hora = horaFinal
            minutos = minutosFinal
            segundos = segundosFinal
            return true
        }
    }

    fun decrementar(t:Tiempo):Boolean{
        var horaFinal = hora - t.hora
        var minutosFinal = minutos - t.minutos
        var segundosFinal = segundos - t.segundos

        if(segundosFinal > 59){
            minutosFinal -= (segundosFinal / 60)
            minutosFinal %= 60
        }

        if(minutosFinal > 59){
            horaFinal -= (segundosFinal / 60)
            minutosFinal %= 60
        }
        if(horaFinal < 0){
            return false
        }
        else{
            hora = horaFinal
            minutos = minutosFinal
            segundos = segundosFinal
            return true
        }
    }

    fun comparar(t:Tiempo):Int{
        var sumaHoras1 = hora+minutos+segundos
        var sumaHoras2 = t.hora + t.minutos + t.segundos
        return when {
            (sumaHoras1 == sumaHoras2) -> 0
            (sumaHoras1 > sumaHoras2)-> 1
            else -> {-1}
        }
    }

    fun copiar(t:Tiempo):Tiempo{
        return Tiempo(t.hora,t.minutos,t.segundos)
    }

    fun copiar():Tiempo{
        return Tiempo(hora,minutos,segundos)
    }

    fun sumar(t:Tiempo):Tiempo?{
        if(incrementar(t)){
        var horaFinal = hora + t.hora
        var minutoFinal = minutos + t.minutos
        var segundosFinal = segundos + t.segundos
        if(segundosFinal > 59){
            minutoFinal += (segundosFinal / 60)
            minutoFinal %= 60
        }

        if(minutoFinal > 59){
            horaFinal += (segundosFinal / 60)
            minutoFinal %= 60
        }
        if(horaFinal >= 24){
            return null
        }
        else{
            return Tiempo(horaFinal,minutoFinal,segundosFinal)
        }
        }
        return null
    }

    fun restar(t:Tiempo):Tiempo?{
        if(decrementar(t)){
            var horaFinal = hora - t.hora
            var minutoFinal = minutos - t.minutos
            var segundosFinal = segundos - t.segundos
            if(segundosFinal > 59){
                minutoFinal -= (segundosFinal / 60)
                minutoFinal %= 60
            }

            if(minutoFinal > 59){
                horaFinal -= (segundosFinal / 60)
                minutoFinal %= 60
            }
            if(horaFinal < 0){
                return null
            }
            else{
                return Tiempo(horaFinal,minutoFinal,segundosFinal)
            }
        }
        return null
    }

    fun esMayorQue(t:Tiempo):Boolean{
        var sumaHora1 = hora+minutos+segundos
        var sumaHora2 = t.hora + t.minutos + t.segundos
        if(sumaHora1 > sumaHora2){
            return true
        }
        else{
            return false
        }
    }

    fun esMenorQue(t:Tiempo):Boolean{
        var sumaHora1 = hora+minutos+segundos
        var sumaHora2 = t.hora + t.minutos + t.segundos
        if(sumaHora1 < sumaHora2){
            return true
        }
        else{
            return false
        }
    }


    constructor(hora:Int,minutos:Int):this(hora,minutos,0){

    }

    constructor(hora:Int):this(hora,0,0){

    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minutos)}m ${"%02d".format(segundos)}s "
    }
}