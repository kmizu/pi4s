package com.github.kmizu.pi4s

object Main {
  def main(args: Array[String]): Unit = {
    val times = if(args.length == 0) 10 else args(0).toInt
    val interval = if(args.length < 2) 1000 else args(1).toInt
    val pin = PiGpio.output(GPIO_25)
    def blink(times: Int): Unit = {
      for(_ <- 0 until times) {
        Thread.sleep(interval)
        pin.toggle()
      }
    }
    blink(times)
  }
}
