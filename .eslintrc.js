module.exports = {
  env: {
    browser: true,
    es2021: true,
    // node: true,
  },
  extends: ['eslint:recommended', 'plugin:react/recommended', 'plugin:@typescript-eslint/recommended'],
  overrides: [],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  plugins: ['react'],
  ignorePatterns: ['node_modules/'],
  rules: {
    'react/react-in-jsx-scope': 0,
    'react/jsx-no-target-blank': 0,
    '@typescript-eslint/no-empty-function': 0,
  },
};
