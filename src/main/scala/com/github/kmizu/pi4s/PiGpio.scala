package com.github.kmizu.pi4s

import com.pi4j.io.gpio.{GpioFactory, GpioPinDigitalInput, GpioPinDigitalOutput, Pin, PinState}

object PiGpio {
  setup()
  private[this] val gpio = GpioFactory.getInstance()
  def output(pin: Pin): GpioPinDigitalOutput = {
    gpio.provisionDigitalOutputPin(pin)
  }
  def input(pin: Pin): GpioPinDigitalInput = {
    gpio.provisionDigitalInputPin(pin)
  }
}
