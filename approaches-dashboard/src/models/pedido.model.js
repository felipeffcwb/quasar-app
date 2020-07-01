import { StatusPedido } from '../enums/statusPedido.enum'
import { Influencer } from '../models/influencer.model'
import { Cliente } from '../models/Cliente.model'

export class Pedido {
  recebedorNome
  descricao
  statusPedido = StatusPedido
  influencer = Influencer
  cliente = Cliente
}
