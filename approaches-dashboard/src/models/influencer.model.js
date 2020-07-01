import { StatusInfluencer } from '../enums/statusInfluencer.enum'
import { Pedido } from '../models/pedido.model'

export class Influencer {
  nome
  email
  statusInfluencer = StatusInfluencer
  pedidos = [Pedido]
}
