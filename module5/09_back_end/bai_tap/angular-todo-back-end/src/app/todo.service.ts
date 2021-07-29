import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Todo} from "./todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
    API_URL = 'http://localhost:3000';
  constructor(private http: HttpClient) { }
  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.API_URL + '/todos');
  }
  save(todo: Todo): Observable<Todo>{
    return this.http.post<Todo>(this.API_URL + '/todos', todo);
  }
  findById(id: number): Observable<Todo> {
    return this.http.get<Todo>(`${this.API_URL}/todos/${id}`);
  }
  edit(id: number, todo: Todo): Observable<Todo>{
    return this.http.put<Todo>(`${this.API_URL}/todos/${id}`, todo);
  }
  delete(id: number): Observable<Todo>{
    return this.http.delete<Todo>(`${this.API_URL}/todos/${id}`);
  }
}
