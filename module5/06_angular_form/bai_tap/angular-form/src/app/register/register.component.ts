import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import {Register} from '../register';

function mismatchedPasswords(passwordKey: string, confirmPasswordKey: string) {
  return (group: FormGroup): { [key: string]: any } => {
    const password = group.controls[passwordKey];
    const confirmPassword = group.controls[confirmPasswordKey];

    if (password.value !== confirmPassword.value) {
      return {
        mismatchedPasswords: true
      };
    }
  };
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  contactForm: FormGroup;
  registers: Register[] = [];
  countryList = [
    'Viet Nam',
    'USA',
    'Canada'
  ];

  constructor(private fb: FormBuilder) {
    this.contactForm = this.fb.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
    }, {validators: mismatchedPasswords('password', 'confirmPassword')});
  }

  ngOnInit(): void {
  }

  onSubmit() {
      const register: Register = {
        email: this.contactForm.controls.email.value,
        password: this.contactForm.controls.password.value,
        country: this.contactForm.controls.country.value,
        age: this.contactForm.controls.age.value,
        gender: this.contactForm.controls.gender.value,
        phone: this.contactForm.controls.phone.value
      };
      this.registers.push(register);
  }
}
