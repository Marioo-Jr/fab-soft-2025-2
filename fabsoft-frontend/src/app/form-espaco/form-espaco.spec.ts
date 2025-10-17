import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEspaco } from './form-espaco';

describe('FormEspaco', () => {
  let component: FormEspaco;
  let fixture: ComponentFixture<FormEspaco>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormEspaco]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormEspaco);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
