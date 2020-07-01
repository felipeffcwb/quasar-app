import { StatusCliente } from '../enums/statusCliente.enum'
import { Pedido } from '../models/pedido.model'

export class Cliente {
  nome
  email
  statusInfluencer = StatusCliente
  pedidos = [Pedido]
}
