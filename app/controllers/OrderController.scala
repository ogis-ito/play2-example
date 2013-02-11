package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

import models.Order

object OrderController extends Controller {

  val form = Form(
    mapping(
      "orderDate" -> date,
      "customerId" -> longNumber
    )(Order.apply)(Order.unapply)
  )

  def index = Action {
    Ok(views.html.order.index(Order.findAll()))
  }

  def persist = Action { implicit request =>
    form.bindFromRequest.value.map { order =>
      Order.persist(order)
      Redirect(routes.OrderController.index)
    } getOrElse BadRequest
  }

  def remove(id: Long) = Action {
    Order.remove(id)
    Redirect(routes.OrderController.index)
  }
}
