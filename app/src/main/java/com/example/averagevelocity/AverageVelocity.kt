package com.example.averagevelocity

class AverageVelocity(
    private val ti: Double,
    private val tf: Double,
    private val vi: Double,
    private val vf: Double,
    ) {

    fun calcular() :Double = tf - ti / vf - vi
}