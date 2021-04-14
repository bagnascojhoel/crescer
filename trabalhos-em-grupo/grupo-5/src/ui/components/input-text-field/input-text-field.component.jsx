import React from 'react';
import './style.css';

const defaultProps = {
  onChange: () => {},
};

export function InputTextField({
  onChange,
  placeholder,
  label,
  type,
  name,
  value,
  required,
}) {
  const _onChange = (event) => {
    onChange(event.target.value);
  };

  return (
    <div className="input-text-field">
      <label className="input-text-field__label" htmlFor={name ?? label}>
        {label}
      </label>
      <input
        className="input-text-field__input"
        type={type}
        onChange={_onChange}
        value={value}
        placeholder={placeholder}
        required={required}
      />
    </div>
  );
}

InputTextField.defaultProps = defaultProps;
