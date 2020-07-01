<template>
  <q-page padding>
    <div class="row justify-end q-pb-sm">
      <q-btn color="primary" icon="add" round @click="modal = true, showing = true">
        <q-tooltip
          content-class="light-dimmed"
          v-model="showing"
          anchor="center right"
          self="center left"
          transition-show="rotate"
          transition-hide="rotate"
        >adicionar</q-tooltip>
      </q-btn>
    </div>
    <q-dialog v-model="modal">
      <q-card style="width: 300px">
        <q-card-section>
          <div class="text-h6">Nome</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <q-input dense v-model="clientes.nome" autofocus @keyup.enter="modal = false" />
        </q-card-section>

        <q-card-section>
          <div class="text-h6">E-mail</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <q-input dense v-model="clientes.email" @keyup.enter="modal = false" />
        </q-card-section>

        <q-card-actions align="right" class="text-primary">
          <q-btn flat label="Cancelar" v-close-popup @click="showing = false" />
          <q-btn flat label="Adicionar" v-close-popup @click="showing = false, addCliente()" />
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-separator />
    <q-list separator>
      <q-item v-for="cli in getters" :key="cli.id" class="q-my-sm" clickable v-ripple>
        <q-item-section avatar>
          <q-avatar color="primary" text-color="white">{{ cli.nome.charAt().toUpperCase() }}</q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>{{ cli.nome }}</q-item-label>
          <q-item-label caption lines="1">{{ cli.email }}</q-item-label>
        </q-item-section>

        <q-item-section side>
          <q-icon name="delete" color="red" size="1.5em"  />
        </q-item-section>

        <q-dialog v-model="modalDelete" persistent>
          <q-card>
            <q-card-section class="row items-center">
              <q-avatar icon="warning" color="red" text-color="white" />
              <span class="q-ml-sm">Tem certeza que deseja excluir este Cliente ?</span>
            </q-card-section>

            <q-card-actions align="right">
              <q-btn flat label="Cancelar" color="primary" v-close-popup />
              <q-btn
                flat
                label="Deletar"
                color="primary"
                v-close-popup
              />
            </q-card-actions>
          </q-card>
        </q-dialog>

        <q-item-section side>
          <q-icon name="create" color="primary" size="1.5em"/>
        </q-item-section>
        <q-dialog v-model="modalUpdate">
          <q-card style="width: 300px">
            <q-card-section>
              <div class="text-h6">Nome</div>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <q-input dense v-model="cliente.nome"  autofocus @keyup.enter="modal = false" />
            </q-card-section>

            <q-card-section>
              <div class="text-h6">E-mail</div>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <q-input dense v-model="cliente.email"  @keyup.enter="modal = false" />
            </q-card-section>

            <q-card-actions align="right" class="text-primary">
              <q-btn flat label="Cancelar" v-close-popup @click="showing = false" />
              <q-btn
                flat
                label="Adicionar"
                v-close-popup
              />
            </q-card-actions>
          </q-card>
        </q-dialog>
      </q-item>
    </q-list>
  </q-page>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import { Cliente } from 'src/models/cliente.model'
import { StatusCliente } from 'src/enums/statusCliente.enum'
export default {
  data () {
    return {
      showing: false,
      modal: false,
      response: false,
      modalDelete: false,
      modalUpdate: false,
      clientes: new Cliente(),
      cliente: new Cliente()
    }
  },
  computed: {
    ...mapGetters('clientes', ['getters'])
  },
  mounted () {
    this.getClientes()
  },
  methods: {
    ...mapActions('clientes', [
      'addClientes',
      'getCliente'
    ]),
    addCliente () {
      this.clientes.statusCliente = StatusCliente.ATIVO
      this.clientes.pedidos = []
      this.addClientes(this.clientes)
      this.cleanForm()
    },
    getClientes () {
      this.getCliente()
    },
    cleanForm () {
      this.clientes = {}
    }
  }
}
</script>
