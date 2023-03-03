import { render, screen } from '@testing-library/react';
import { describe, expect, it } from 'vitest';

import App from '@/common/primary/app/App';

describe('App tests', () => {
  it('renders without crashing', () => {
    render(<App />);
  });
  it('renders hello world', () => {
    // ARRANGE
    render(<App />);
    // ACT
    // EXPECT
    expect(
      screen.getByRole('heading', {
        level: 1,
      })
    ).toHaveTextContent('Hello World');
  });
});
