<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title class="flex justify-end">
          Approaches
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-1"
    >
      <q-list >
        <q-item-label
          header
          class="text-grey-8"
        >
          <q-icon style="cursor: pointer;" name="keyboard_backspace" size="1.5rem" color="primary" @click="leftDrawerOpen = !leftDrawerOpen"/>
        </q-item-label>
        <q-item clickable v-ripple >
          <q-item-section class="items-start">
            <q-btn flat color="primary" icon="record_voice_over" label="Influencers" to="/influencers"/>
            <q-btn flat color="primary" icon="supervisor_account" label="Clientes" to="/clientes"/>
            <q-btn flat color="primary" icon="shopping_basket" label="Pedidos" />
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>

export default {
  name: 'MainLayout',

  data () {
    return {
      leftDrawerOpen: false
    }
  }
}
</script>
