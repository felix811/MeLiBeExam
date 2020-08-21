# MeLiBeExam - Felix Sabate

## *Descripción*
Este proyecto contiene la resolución del examen de ingreso para Desarrollador BackEnd en Mercado Libre.
Se encuentra desarrollado en Java + Spring Boot y utiliza PostgreSQL cómo motor de Base de Datos.
El proyecto está modelado con DDD. Incluye Test unitarios con Code coverage > 95%.

##*Api URL*

La Api se encuentra hosteada en Gloogle App Engine. El link de la misma es:

```
	https://secure-wonder-285918.rj.r.appspot.com
```

### *Metodos expuestos*


### *Verificacion de ADN*

Para determinar si una cadena de ADN pertenece a un mutante utilizar el endpoint

```
	.../mutant/
```

Se debe invocar mediante HTTP Post, por ejémplo:

```
	{
		"dna":["GTTCA","ACGTA","GCTCG","ATAGA","AGGTT"]
	}
```

En caso de que el ADN corresponda a un mutante se devolverá un HTTP 200-OK, en caso contrario un
403-Forbidden


### *Estadísticas*

Para obtener las estadísticas de la cantidad de ADN Humano y Mutante analizado se debe consultar el siguiente endpoint con un HTTP GET

```
	.../stats
```
La respuesta presenta el siguiente formato

```
	{
	    "count_mutant_dna": 2,
	    "count_human_dna": 4,
	    "ratio": 0.5
	}
```



