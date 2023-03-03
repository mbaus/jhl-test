module.exports = {
  env: {
    browser: true,
    es2021: true,
    // node: true,
  },
  extends: [
    'airbnb',
    'airbnb-typescript',
    'airbnb/hooks',
    'plugin:react/recommended',
    'plugin:@typescript-eslint/recommended',
    'plugin:prettier/recommended',
  ],
  overrides: [],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
    project: './tsconfig.json',
  },
  plugins: ['react', '@typescript-eslint', 'prettier'],
  ignorePatterns: ['node_modules/'],
  rules: {
    'react/react-in-jsx-scope': 0,
    'react/jsx-no-target-blank': 0,
    '@typescript-eslint/no-empty-function': 0,
  },
};
