package com.github.kmizu

import com.pi4j.io.gpio._
import com.pi4j.wiringpi._

package object pi4s {
  def setup(): Unit = {
    Gpio.wiringPiSetupGpio()
  }
  val GPIO_00 = RaspiPin.GPIO_00
  val GPIO_01 = RaspiPin.GPIO_01
  val GPIO_02 = RaspiPin.GPIO_02
  val GPIO_03 = RaspiPin.GPIO_03
  val GPIO_04 = RaspiPin.GPIO_04
  val GPIO_05 = RaspiPin.GPIO_05
  val GPIO_06 = RaspiPin.GPIO_06
  val GPIO_07 = RaspiPin.GPIO_07
  val GPIO_08 = RaspiPin.GPIO_08
  val GPIO_09 = RaspiPin.GPIO_09
  val GPIO_10 = RaspiPin.GPIO_10
  val GPIO_11 = RaspiPin.GPIO_11
  val GPIO_12 = RaspiPin.GPIO_12
  val GPIO_13 = RaspiPin.GPIO_13
  val GPIO_14 = RaspiPin.GPIO_14
  val GPIO_15 = RaspiPin.GPIO_15
  val GPIO_16 = RaspiPin.GPIO_16
  val GPIO_17 = RaspiPin.GPIO_17
  val GPIO_18 = RaspiPin.GPIO_18
  val GPIO_19 = RaspiPin.GPIO_19
  val GPIO_20 = RaspiPin.GPIO_20
  val GPIO_21 = RaspiPin.GPIO_21
  val GPIO_22 = RaspiPin.GPIO_22
  val GPIO_23 = RaspiPin.GPIO_23
  val GPIO_24 = RaspiPin.GPIO_24
  val GPIO_25 = RaspiPin.GPIO_25
  val GPIO_26 = RaspiPin.GPIO_26
  val GPIO_27 = RaspiPin.GPIO_27
  val GPIO_28 = RaspiPin.GPIO_28
  val GPIO_29 = RaspiPin.GPIO_29
  val GPIO_30 = RaspiPin.GPIO_30
  val GPIO_31 = RaspiPin.GPIO_31
}
