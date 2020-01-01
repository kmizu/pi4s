package com.github.kmizu

import com.pi4j.io.gpio._
import com.pi4j.wiringpi._

package object pi4s {
  def setup(): Unit = {
    Gpio.wiringPiSetupGpio()
  }
}
