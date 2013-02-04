import play.api.db.DB
import play.api.GlobalSettings

import org.squeryl.adapters._
import org.squeryl.internals.DatabaseAdapter
import org.squeryl.{Session, SessionFactory}

import play.api.Application

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    SessionFactory.concreteFactory =
      app.configuration.getString("db.default.driver") match {
      case Some("org.h2.Driver") =>
        Some(() => getSession(app, new H2Adapter))
      case Some("com.mysql.jdbc.Driver") =>
        Some(() => getSession(app, new MySQLAdapter))
      case _ =>
        sys.error("Database driver must be either org.h2.Driver or com.mysql.jdbc.Driver")
    }
  }

  def getSession(app: Application, adapter: DatabaseAdapter) =
    Session.create(DB.getConnection()(app), adapter)

}
