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
          <q-input dense v-model="influencers.nome" autofocus @keyup.enter="modal = false" />
        </q-card-section>

        <q-card-section>
          <div class="text-h6">E-mail</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <q-input dense v-model="influencers.email" @keyup.enter="modal = false" />
        </q-card-section>

        <q-card-actions align="right" class="text-primary">
          <q-btn flat label="Cancelar" v-close-popup @click="showing = false" />
          <q-btn flat label="Adicionar" v-close-popup @click="showing = false, addInfluencer()" />
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-separator />
    <q-list separator>
      <q-item v-for="inf in getters" :key="inf.id" class="q-my-sm" clickable v-ripple>
        <q-item-section avatar>
          <q-avatar color="primary" text-color="white">{{ inf.nome.charAt().toUpperCase() }}</q-avatar>
        </q-item-section>

        <q-item-section>
          <q-item-label>{{ inf.nome }}</q-item-label>
          <q-item-label caption lines="1">{{ inf.email }}</q-item-label>
        </q-item-section>

        <q-item-section side>
          <q-icon name="delete" color="red" size="1.5em" @click="modalDelete = true, getDelete(inf)" />
        </q-item-section>

        <q-dialog v-model="modalDelete" persistent>
          <q-card>
            <q-card-section class="row items-center">
              <q-avatar icon="warning" color="red" text-color="white" />
              <span class="q-ml-sm">Tem certeza que deseja excluir este Influencer ?</span>
            </q-card-section>

            <q-card-actions align="right">
              <q-btn flat label="Cancelar" color="primary" v-close-popup />
              <q-btn
                flat
                label="Deletar"
                color="primary"
                v-close-popup
                @click="deleteInfluencers(inf)"
              />
            </q-card-actions>
          </q-card>
        </q-dialog>

        <q-item-section side>
          <q-icon name="create" color="primary" size="1.5em" @click="modalUpdate = true, showing = true, getUpdate(inf)"/>
        </q-item-section>
        <q-dialog v-model="modalUpdate">
          <q-card style="width: 300px">
            <q-card-section>
              <div class="text-h6">Nome</div>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <q-input dense v-model="influencer.nome"  autofocus @keyup.enter="modal = false" />
            </q-card-section>

            <q-card-section>
              <div class="text-h6">E-mail</div>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <q-input dense v-model="influencer.email"  @keyup.enter="modal = false" />
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
import { Influencer } from 'src/models/influencer.model'
import { StatusInfluencer } from 'src/enums/statusInfluencer.enum'
export default {
  data () {
    return {
      showing: false,
      modal: false,
      response: false,
      modalDelete: false,
      modalUpdate: false,
      influencers: new Influencer(),
      influencer: new Influencer()
    }
  },
  computed: {
    ...mapGetters('influencers', ['getters'])
  },
  mounted () {
    this.getInfluencers()
  },
  methods: {
    ...mapActions('influencers', [
      'addInfluencers',
      'getInfluencer',
      'deleteInfluencer'
    ]),
    addInfluencer () {
      this.influencers.statusInfluencer = StatusInfluencer.ATIVO
      this.influencers.pedidos = []
      this.addInfluencers(this.influencers)
      this.cleanForm()
    },
    getDelete (Object) {
      this.influencer = Object
    },
    deleteInfluencers () {
      this.deleteInfluencer(this.influencer)
    },
    getUpdate (Object) {
      this.influencer = Object
    },
    getInfluencers () {
      this.getInfluencer()
    },
    cleanForm () {
      this.influencers = {}
    }
  }
}
</script>
