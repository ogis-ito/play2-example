package models

import org.squeryl.KeyedEntity

class EntityBase extends KeyedEntity[Long] {

  val id: Long = 0
}
