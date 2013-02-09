package models

import org.squeryl.Schema

object AppDB extends Schema {

  val customerTable = table[Customer]("T_CUSTOMER")

}
