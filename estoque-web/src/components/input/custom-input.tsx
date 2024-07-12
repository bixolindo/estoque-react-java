import React from 'react';
import { StyledInput } from './styles';

interface Props {
    onChange?: (event: React.ChangeEvent<HTMLInputElement>) => void;
    label: string;
    accessibilityLabel: string;
    disabled?: boolean;
    type: string;
    required?: boolean;
    value: string;
}

export const CustomInput = ({ label, onChange, value, type, required = true, accessibilityLabel, disabled = false }: Props) => {

    return (
        <StyledInput
            label={label}
            required={required}
            type={type}
            onChange={onChange}
            value={value}
            variant="outlined"
            aria-label={accessibilityLabel}
            disabled={disabled}
        />
    );
}

export default CustomInput;