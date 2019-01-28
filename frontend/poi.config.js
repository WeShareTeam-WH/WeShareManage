const path = require('path');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
  babel: {
    jsx: 'vue'
  },
  entry: {
    main: './src/main.js'
  },
  configureWebpack(config, context) {
    alias = {
      'vue$': 'vue/dist/vue.esm.js'
    }
    Object.assign(config.resolve.alias, alias);

    config.plugins.push(new CleanWebpackPlugin(['dist']));
  },
}